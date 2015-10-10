import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class ClipPlayer {
	Map<String, Clip>clipMap = new HashMap<String, Clip>();
	// I use the map above to associate the String command with a Sound Clip.  If you wish to play the 
	// Clip later, you invoke the play method passing in the String you used to map to the Clip.  I had
	// a problem with mp3 files.  My guess is that it has something to do with drivers and platforms, but 
	// I will continue to work out those issues.
	
	
	public void mapFile(String command, String path){
		// add a soundclip to the map.  This will map the command 
		// to the clip that is opened at the indicated path
		// do this early in the loadup of the application

		Clip clip= null;
		
		// careful here.  I placed all the sounds I used into a folder called sounds which was in a folder
		// called res (for resources) which was in my project folder.  Should allow for exporting easily...
		URL url = getClass().getResource("sounds/"+path); 
		
		System.out.println(url);
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(url);
			AudioFormat format = stream.getFormat();
			if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				format = new AudioFormat(
						AudioFormat.Encoding.PCM_SIGNED,
						format.getSampleRate(),
						format.getSampleSizeInBits()*2,
						format.getChannels(),
						format.getFrameSize()*2,
						format.getFrameRate(),
						true);        
				stream = AudioSystem.getAudioInputStream(format, stream);
			}

			// Create the clip
			DataLine.Info info = new DataLine.Info(
					Clip.class, stream.getFormat(), ((int)stream.getFrameLength()*format.getFrameSize()));
			clip = (Clip) AudioSystem.getLine(info);

			// This method does not return until the audio file is completely loaded
			clip.open(stream);

		}catch (Exception e) {
			System.out.println("Problem with sound loading \n"+ e);

		}
		clipMap.put(command,clip);
	}
	
	public void play(String command) {
		Clip c = clipMap.get(command);
		//System.out.println("Trying to play "+c);
		
		// not sure if any of this was necessary.  I was troubleshooting to find out 
	   // why the Clips wouldn't play a second time.  Resetting the frame position worked.
	//	if(c.isRunning()) {
	//		c.stop();
    //		c.flush();
			
	//	}
		c.setFramePosition(0);
		c.start();
	}
}

