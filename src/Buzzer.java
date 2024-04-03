import java.util.ArrayList;
import java.util.List;

public class Buzzer {
	private List<Button> buttons;
	private int id;
	
	public Buzzer(int id, char[] keys) {
		this.id = id;
		buttons = new ArrayList<>();
		for (int i = 0; i < keys.length; i++) {
			buttons.add(new Button(keys[i],Color.getColor(i)));
		}
	}
	
	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public boolean containsKeyCode(int keyCode) {
		boolean containsKeyCode = false;
		for (Button button : buttons) {
			if (button.getKeyCode() == keyCode) {
				containsKeyCode = true;
			}
		}
		
		return containsKeyCode;
	}
	
	public Button getButton(int keyCode) {
		Button button = null;
		for (Button eachButton : buttons) {
			if (eachButton.getKeyCode() == keyCode) {
				button = eachButton;
			}
		}
		
		return button;
	}

	@Override
	public String toString() {
		String string = id + ": ";
		for (Button button : buttons) {
			string = string + button.toString() + '\n';
		}
		return string;
	}
}
