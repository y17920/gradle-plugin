package com.github.y17920.plugin.task;

import com.github.y17920.plugin.bean.JiaguExtention;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

import java.io.File;

import javax.inject.Inject;
/**
 * @author yuteng
 * @Description:
 * @date 2021/5/23 14:28
 * @Since version 2021/5/23
 */
public class JiaguTask extends DefaultTask {


    private final File           mFile;
    private final JiaguExtention mJiaju;

    @Inject
    public JiaguTask(File file, JiaguExtention jiaju) {
        setGroup("y17920");
        mFile = file;
        mJiaju = jiaju;
    }

    @TaskAction
    public void jiagu() {
        if (null ==mJiaju ){
            System.out.println("Jiaju NullPointerException 没有设置加固配置");
        }
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", mJiaju.getJiaGuPluginPath(),
                        "-login", mJiaju.getJiaGuUserName(), mJiaju.getJiaGuPwd());
            }
        });
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", mJiaju.getJiaGuPluginPath(),
                        "-importsign", mJiaju.getStoreFilePath(), mJiaju.getStorePassword(), mJiaju.getKeyAlias(), mJiaju.getKeyPassword());
            }
        });
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", mJiaju.getJiaGuPluginPath(),
                        "-jiagu", mFile.getAbsolutePath(), mFile.getParent(), "-autosign");
            }
        });

    }
}
