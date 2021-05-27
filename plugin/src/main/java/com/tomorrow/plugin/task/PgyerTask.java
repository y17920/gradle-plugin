package com.tomorrow.plugin.task;

import com.android.build.gradle.api.BaseVariantOutput;
import com.tomorrow.plugin.bean.PgyerExtention;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

import java.io.ByteArrayOutputStream;

import javax.inject.Inject;

/**
 * @author yuteng
 * @date 2021/5/23 15:37
 */
public class PgyerTask extends DefaultTask {

    private BaseVariantOutput mOutput;
    private PgyerExtention    mPgyerExtention;
    private boolean           mIsJiagu;
    private String            mVersionName;

/*    @Inject
    public PgyerTask(BaseVariantOutput file, PgyerExtention pgyerExtention) {
        setGroup("tomorrow");
        mOutput = file;
        mPgyerExtention = pgyerExtention;
    }*/

    @Inject
    /**
     *
     */
    public PgyerTask(BaseVariantOutput output, PgyerExtention pgyerExtention, boolean isJiagu, String versionName) {
        setGroup("tomorrow");
        mOutput = output;
        mPgyerExtention = pgyerExtention;
        mIsJiagu = isJiagu;
        mVersionName = versionName;
    }

    @TaskAction
    public void pgyer() {

        System.out.println(mOutput.toString());
        System.out.println(mPgyerExtention.toString());
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec spec) {
                String path = mOutput.getOutputFile().getAbsolutePath();
                if (mIsJiagu) {
                    path = path.replace(".apk", "_" + mVersionName.replace(".", "") + "_jiagu_sign.apk");
                }
                ByteArrayOutputStream stdout = new ByteArrayOutputStream();
                spec.executable("curl");
                spec.args("-F", "file=@" + path,
                        "-F", "_api_key=" + mPgyerExtention.getPgyerApiKey(),
                        "-F", "buildInstallType=" + mPgyerExtention.getPgyerApiKey(),
                        "-F", "buildPassword=" + mPgyerExtention.getBuildPassword(),
                        "-F", "buildUpdateDescription=" + mPgyerExtention.getBuildUpdateDescription(),
                        "-F", "buildName=" + mPgyerExtention.getBuildName(),
                        "-F", "buildInstallQuestoin=" + mPgyerExtention.getBuildInstallQuestoin(),
                        "-F", "buildInstallAnswer=" + mPgyerExtention.getBuildInstallAnswer(),
                        "-F", "buildInstallDate=" + mPgyerExtention.getBuildInstallDate(),
                        "-F", "buildInstallStartDate=" + mPgyerExtention.getBuildInstallStartDate(),
                        "-F", "buildInstallEndDate=" + mPgyerExtention.getBuildInstallEndDate(),
                        "https://www.pgyer.com/apiv2/app/upload");
                spec.setStandardOutput(stdout);
                String output = stdout.toString();
                System.out.println(output);
            }
        });

    }
}

