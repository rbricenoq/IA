
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import weka.core.*;
import weka.core.FastVector;
import weka.classifiers.meta.FilteredClassifier;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class main {

	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub

		final String archivo = "tweets.txt";

		Instance instances;
		FilteredClassifier clasificador;		
		normalize n = new normalize();	

		//Configuración de Key		
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("V69AqxEi1nXFZIwWC9xbYtJWO")
		.setOAuthConsumerSecret("XH76gF3p6yS4tee5G8dCG5YgUMaiYueRVfSjLijzTrz0h3KOwS")
		.setOAuthAccessToken("285355983-SLgw4H56EWUbevC3NQmr91Rl2ll82oWsVp9VIwp1")
		.setOAuthAccessTokenSecret("cQbpiwAHjS7zfa9xVp4V8ZrgCwQm8cdFKDcko3GEafy3U");

		//Cración de documento

		TwitterFactory tweets = new TwitterFactory(cf.build()); 
		twitter4j.Twitter tw = tweets.getInstance();
		List<Status> status = tw.getHomeTimeline();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
			for(Status st: status) {
				bw.write(n.NormalizeText(st.getText()));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace ();
		}

		//Clasificador
		
		clasificador classifier;
			classifier = new clasificador();
			classifier.load("tweets.txt");
			//classifier.loadModel(args[1]);
			classifier.makeInstance();
			classifier.classify();
	}
} 	