package apps.oreonworlds.gui;

import modules.gui.GUIElement;
import modules.gui.Screen;

public class GUI extends modules.gui.GUI{

	private OpenCloseButton openCloseButton;
	private Screen guiButtonsPanel;
	
	@Override
	public void init() {
		Screen screen0 = new Screen();
		screen0.setElements(new GUIElement[2]);
		openCloseButton =  new OpenCloseButton();
		screen0.getElements()[0] = new FPSPanel();
		screen0.getElements()[1] = openCloseButton;
		screen0.init();
		getScreens().add(screen0);
		
		guiButtonsPanel = new Screen();
		guiButtonsPanel.setElements(new GUIElement[1]);
		guiButtonsPanel.getElements()[0] = new GridButton();
//		guiButtonsPanel.getElements()[1] = new MotionBlurFonts();
//		guiButtonsPanel.getElements()[2] = new DepthOfFieldBlurFonts();
//		guiButtonsPanel.getElements()[3] = new MotionBlurButton();
//		guiButtonsPanel.getElements()[4] = new DepthOfFieldBlurButton();
//		guiButtonsPanel.getElements()[5] = new BloomFonts();
//		guiButtonsPanel.getElements()[6] = new BloomButton();
		guiButtonsPanel.init();
	}
	
	@Override
	public void update(){
		super.update();
		if (!openCloseButton.isClosed()){
			if (getScreens().size() == 1)
				getScreens().add(guiButtonsPanel);
		}
		else if (openCloseButton.isClosed()){
			if (getScreens().size() == 2)
				getScreens().remove(1);
		}
	}
}
