import java.awt.*;
import java.applet.*;

public class AudioEx extends Applet {
	private AudioClip audio;
	private Label lab;

	public void init() {
		lab = new Label("Can you hear the sounds?", Label.CENTER);
		lab.setFont(new Font("����ü", Font.BOLD, 25));
		setLayout(new BorderLayout());
		add("North", lab);
		try {
			audio = getAudioClip(getCodeBase(), "image/spacemusic.au");
		} catch(Exception e) {}
	}

	public void start() {
		try {
			audio.loop();
		} catch(Exception e) {}
	}
}