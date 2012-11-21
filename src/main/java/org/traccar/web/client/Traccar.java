package org.traccar.web.client;

import org.traccar.web.client.login.LoginController;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Entry point class
 */
public class Traccar implements EntryPoint, LoginController.LoginHandler {

    private DevicePanel devicePanel;
    private ArchivePanel archivePanel;
    private MapPanel mapPanel;

    /**
     * Entry point method
     */
    @Override
    public void onModuleLoad() {
        //new LoginController().login(this);

        /*try {
            GlobalDatabaseService.getInstance().getPositions(
                    new Device(1), new Date(1325430000000L), new Date(1325437200000L),
                    new AsyncCallback<List<Position>>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            SC.warn("onFailure");
                        }
                        @Override
                        public void onSuccess(List<Position> positions) {
                            SC.warn("onSuccess");
                        }
                    });
        } catch (Exception error) {
            SC.warn(error.getMessage());
        }*/


        devicePanel = new DevicePanel();
        devicePanel.setWidth("20%");
        devicePanel.setShowResizeBar(true);

        mapPanel = new MapPanel();
        mapPanel.setWidth("80%");

        HLayout hLayout = new HLayout();
        hLayout.setHeight("70%");
        hLayout.addMember(devicePanel);
        hLayout.addMember(mapPanel);
        hLayout.setShowResizeBar(true);
        hLayout.setResizeBarTarget("next");

        archivePanel = new ArchivePanel();
        archivePanel.setHeight("30%");

        VLayout mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.addMember(hLayout);
        mainLayout.addMember(archivePanel);
        mainLayout.draw();
    }

    @Override
    public void onLogin() {
        SC.warn("Woooohooo");
    }
}
