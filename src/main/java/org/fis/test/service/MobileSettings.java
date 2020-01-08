package org.fis.test.service;

import org.fis.test.util.Avd;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileSettings {

    private String deviceDescriptorFileName;
    private DesiredCapabilities capabilities;

    public MobileSettings(String deviceDescriptorFileName) {
        this.deviceDescriptorFileName = deviceDescriptorFileName;
    }

    public DesiredCapabilities getCapabilities() {
        return this.capabilities;
    }

    public void setCapabilities() {
        this.capabilities = CapabilitiesSettings.set(this.deviceDescriptorFileName);
    }

    public void startSimulator() {
        String deviceName = this.capabilities.getCapability("deviceName").toString();
        String platformName = this.capabilities.getCapability("platformName").toString();
        switch (deviceName) {
            case "iOS":
                //todo
                break;
            case "Android":
            default:
                Avd.start(platformName);
                break;
        }
    }

    public void stopSimulator() {
        String platformName = this.capabilities.getCapability("platformName").toString();
        switch (platformName) {
            case "iOS":
                //todo
                break;
            case "Android":
            default:
                Avd.stop();
                break;
        }
    }
}
