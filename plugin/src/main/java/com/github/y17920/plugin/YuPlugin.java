package com.github.y17920.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariantOutput;
import com.github.y17920.plugin.bean.JiaguExtention;
import com.github.y17920.plugin.bean.PgyerExtention;
import com.github.y17920.plugin.task.JiaguTask;
import com.github.y17920.plugin.task.PgyerTask;

import org.gradle.api.Action;
import org.gradle.api.DomainObjectCollection;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import java.io.File;

/**
 * @author yuteng * @date 2021/5/23 13:43
 */
public class YuPlugin implements Plugin<Project> {
    @Override
    public void apply(Project crt) {
        final JiaguExtention jiagu = crt.getExtensions().create("jiaguExt", JiaguExtention.class);
        final PgyerExtention pgyer = crt.getExtensions().create("pgyerExt", PgyerExtention.class);
        crt.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(final Project project) {
                AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
                appExtension.getApplicationVariants().all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(ApplicationVariant variant) {
                        final String name = variant.getName();
                        final String versionName = variant.getVersionName();
                        DomainObjectCollection<BaseVariantOutput> outputs = variant.getOutputs();
                        outputs.all(new Action<BaseVariantOutput>() {
                            @Override
                            public void execute(BaseVariantOutput output) {
                                String taskName = "assemble" + transformName(name);
                                Task assembleTask = project.getTasks().findByName(taskName);

                                File file = output.getOutputFile();
                                //单纯加固
                                JiaguTask jiaguTask = project.getTasks().create("jiagu" + transformName(name), JiaguTask.class,
                                        file, jiagu);
                                //打包加固
                                JiaguTask assembleJiaguTask = project.getTasks().create("assembleJiagu" + transformName(name), JiaguTask.class,
                                        file, jiagu);
                                assembleJiaguTask.dependsOn(assembleTask);
                                //上传
                                PgyerTask pgyerTask = project.getTasks().create("pgyer" + transformName(name), PgyerTask.class,
                                        output, pgyer, false, versionName);
                                //加固上传
                                PgyerTask jiaguPgyerTask = project.getTasks().create("jiaguPgyer" + transformName(name), PgyerTask.class,
                                        output, pgyer, true, versionName);
                                jiaguPgyerTask.dependsOn(jiaguTask);
                                //打包上传
                                PgyerTask assemblePgyerTask = project.getTasks().create("assemblePgyer" + transformName(name), PgyerTask.class,
                                        output, pgyer, false, versionName);
                                assemblePgyerTask.dependsOn(assembleTask);
                                //打包加固上传
                                PgyerTask assembleJiaguPgyerTask = project.getTasks().create("assembleJiaguPgyer" + transformName(name), PgyerTask.class,
                                        output, pgyer, true, versionName);
                                assembleJiaguPgyerTask.dependsOn(assembleJiaguTask);
                            }
                        });
                    }
                });
            }
        });
    }

    private static String transformName(String originName) {
        if (originName != null && originName.length() > 0) {
            return originName.substring(0, 1).toUpperCase() + originName.substring(1);
        }
        return originName;
    }
}
