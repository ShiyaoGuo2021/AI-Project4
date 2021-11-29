package learn.lc.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Test {

	
	
	
	
	
	public static ArrayList<Example> readearthquake(String file) throws IOException
	{
		
		ArrayList<Example> examples= new ArrayList();
		File data= new File(file);
		Scanner scanner=new Scanner(data);
		scanner.useDelimiter("[,\n]");
		//scanner.useLocale(Locale.ENGLISH);		
		while(scanner.hasNextLine())
		{
			
			Example e= new Example(3);
			e.inputs[0]=1;
			e.inputs[1]=scanner.nextDouble();
			
			e.inputs[2]=scanner.nextDouble();
			
			e.output=scanner.nextDouble();
			examples.add(e);
			scanner.nextLine();
			
		}
		
		scanner.close();
		return examples;
		
	}
	
	public static ArrayList<Example> readhousevotes(String file) throws IOException
	{
		ArrayList<Example> examples= new ArrayList();
		File data= new File(file);
		Scanner scanner=new Scanner(data);
		scanner.useDelimiter("[,\n]");
		while(scanner.hasNext())
		{
			
			Example e= new Example(17);
			e.inputs[0]=1;
			for(int i=1;i<17;i++)
			{
				e.inputs[i]=scanner.nextDouble();
			}
			
			
			e.output=scanner.nextDouble();
			examples.add(e);
			scanner.hasNextLine();
			
		}
		
		scanner.close();
		return examples;
	}
	
	
	
	public static void run() {
		Scanner scan=new Scanner(System.in);
		Plotter plot= new Plotter();
		System.out.println("Which file do you want to learn? Press 1 for earthquake clean, 2 for earthquake noisy,"
				+ "3 for housevotes ");
		int choice1=scan.nextInt();
		System.out.println("What classifier do you want to use? 1 for Perceptron and 2 for Logistic");
		int choice2=scan.nextInt();
		ArrayList<Example> examples=new ArrayList();
		LinearClassifier lc=new PerceptronClassifier(17);
		switch(choice1)
		{
		case 1: 
			try{examples=readearthquake("src/learn/lc/examples/earthquake-clean.data.txt");
			System.out.println("testing earthquake-clean");
			if(choice2==1)
			{
				//double[] weights= {1,1,1};
				 lc= new PerceptronClassifier(3);
			}
			else
			{
				//double[] weights= {1,1,1};
				lc= new LogisticClassifier(3);
			}
			   
			}catch(IOException e)
			{
				e.printStackTrace();
				
			}
			break;
		case 2:
			try{examples=readearthquake("src/learn/lc/examples/earthquake-noisy.data.txt");
			System.out.println("testing earthquake-noisy");
			if(choice2==1)
			{
				//double[] weights= {1,1,1};
				 lc= new PerceptronClassifier(3);
			}
			else
			{
				//double[] weights= {1,1,1};
				 lc= new LogisticClassifier(3);
			}
			   
			}catch(IOException e)
			{
				e.printStackTrace();
				
			}
				
		    break;
		case 3:
			try{examples=readhousevotes("src/learn/lc/examples/house-votes-84.data.num.txt");
			System.out.println("testing housevotes");
			if(choice2==1)
			{
				/*double[] weights=new double[17];
				for(int i=0;i<17;i++)
				{
					weights[i]=1;
				}
				*/
				 lc= new PerceptronClassifier(17);
			}
			else
			{
				/*double[] weights=new double[17];
				for(int i=0;i<17;i++)
				{
					weights[i]=1;
				}
				*/
				 lc= new LogisticClassifier(17);
			}
			   
			}catch(IOException e)
			{
				e.printStackTrace();
				
			}
			
			break;
			
		}
		
		System.out.println("Press 1 for fixed alpha and 2 for decaying alpha");
		int choice3=scan.nextInt();
		
		switch(choice3)
		{
		case 1:
		
			System.out.println("Enter the alpha");
			double alpha=scan.nextDouble();
			System.out.println("Enter the number of steps");
			int nsteps=scan.nextInt();
			lc.train(examples, nsteps, alpha);
		
		  break;
		case 2:
			
			
			LearningRateSchedule rate=new DecayingLearningRateSchedule();
			System.out.println("Enter the number of steps");
			int numsteps=scan.nextInt();
			lc.train(examples, numsteps, rate);
			
		break;
		}
		
		
		
		 
	
	
	}
	
	
	public static void Perceptronearth1()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readearthquake("src/learn/lc/examples/earthquake-clean.data.txt");
		System.out.println("testing earthquake-clean");
		
			
			 lc= new PerceptronClassifier(3);
		
			 lc.train(examples, 700, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
		
	public static void Perceptronearth2()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readearthquake("src/learn/lc/examples/earthquake-noisy.data.txt");
		System.out.println("testing earthquake-noisy");
		
			
			 lc= new PerceptronClassifier(3);
		
			 lc.train(examples, 100000, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static void Perceptronearth3()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readearthquake("src/learn/lc/examples/earthquake-noisy.data.txt");
		System.out.println("testing earthquake-noisy");
		
			
			 lc= new PerceptronClassifier(3);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 100000, rate);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public static void Logisticearth1()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readearthquake("src/learn/lc/examples/earthquake-clean.data.txt");
		System.out.println("testing earthquake-clean");
		
			
			 lc= new LogisticClassifier(3);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 5000, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public static void Logisticearth2()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readearthquake("src/learn/lc/examples/earthquake-noisy.data.txt");
		System.out.println("testing earthquake-noisy");
		
			
			 lc= new LogisticClassifier(3);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 100000, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public static void Logisticearth3()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readearthquake("src/learn/lc/examples/earthquake-noisy.data.txt");
		System.out.println("testing earthquake-noisy");
		
			
			 lc= new LogisticClassifier(3);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 100000, rate);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
		
	public static void Perceptronhouse1()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readhousevotes("src/learn/lc/examples/house-votes-84.data.num.txt");
		System.out.println("testing housevotes");
		
			
			 lc= new PerceptronClassifier(17);
		
			 lc.train(examples, 700, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public static void Perceptronhouse2()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readhousevotes("src/learn/lc/examples/house-votes-84.data.num.txt");
		System.out.println("testing housevotes");
		
			
			 lc= new PerceptronClassifier(17);
		
			 lc.train(examples, 10000, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public static void Perceptronhouse3()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readhousevotes("src/learn/lc/examples/house-votes-84.data.num.txt");
		System.out.println("testing housevotes");
		
			
			 lc= new PerceptronClassifier(17);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 10000, rate);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
		
	
	
	public static void Logistichouse1()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readhousevotes("src/learn/lc/examples/house-votes-84.data.num.txt");
		System.out.println("testing housevotes");
		
			
			 lc= new LogisticClassifier(17);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 5000, 0.05);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
		
	
	public static void Logistichouse2()
	{
		ArrayList<Example> examples;
		LinearClassifier lc;
		try{examples=readhousevotes("src/learn/lc/examples/house-votes-84.data.num.txt");
		System.out.println("testing housevotes");
		
			
			 lc= new LogisticClassifier(17);
			 LearningRateSchedule rate=new DecayingLearningRateSchedule();
			 lc.train(examples, 100000, rate);
			//double[] weights= {1,1,1};
		
		   
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
		
		
	
	
	public static void main(String[] args)
	{
		
		
		
		
		
		Perceptronearth1();
		//Perceptronearth2();
	//Perceptronearth3();
		//Logisticearth1();
		//Logisticearth2();
		//Logisticearth3();
		//Perceptronhouse1();
		//Perceptronhouse2();
		//Perceptronhouse3();
		//Logistichouse1();
		//Logistichouse2();
	}
	
	
		
		
		
	
}
