public class Button {
	private char key;
	private Color color;
	private int keyCode;
	
	public Button (char key, Color color){
		this.key = key;
		this.color = color;
		this.keyCode = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(key);
	}

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getKeyCode() {
		return keyCode;
	}

	@Override
	public String toString() {
		return "Color: " + color.toString() + ". Key: " + key + ". KeyCode: " + keyCode + ".";
	}
}
