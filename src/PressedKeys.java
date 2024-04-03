import java.util.ArrayList;
import java.util.List;

public class PressedKeys {
	private List<PressedKey> pressedKeys;

	public PressedKeys() {
		this.pressedKeys = new ArrayList<PressedKey>();
	}

	public List<PressedKey> getPressedKeys() {
		return pressedKeys;
	}
	
	public void addPressedKey(PressedKey pressedKey) {
		if(!this.hasBuzzerAlreadyPressed(pressedKey.getBuzzer()))
			this.pressedKeys.add(pressedKey);
	}
	
	private boolean hasBuzzerAlreadyPressed(Buzzer buzzer) {
		boolean hasBuzzerAlreadyPressed = false;
		for(PressedKey pressedKey : pressedKeys) {
			if (pressedKey.getBuzzer().getId() == buzzer.getId()) {
				hasBuzzerAlreadyPressed = true;
				break;
			}
		}
		
		return hasBuzzerAlreadyPressed;
	}

	public void setPressedKeys(List<PressedKey> pressedKeys) {
		this.pressedKeys = pressedKeys;
	}
	
	
}
