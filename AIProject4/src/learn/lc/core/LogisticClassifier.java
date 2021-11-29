package learn.lc.core;

import java.util.List;

import learn.math.util.VectorOps;

public class LogisticClassifier extends LinearClassifier {
	
	public LogisticClassifier(double[] weights) {
		super(weights);
	}
	
	public LogisticClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A LogisticClassifier uses the logistic update rule
	 * (AIMA Eq. 18.8): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times h_w(x)(1-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
		// This must be implemented by you
		
		
		for(int a=0;a<weights.length;a++)
		{
			double hw=threshold(VectorOps.dot(this.weights, x));
			weights[a]=weights[a]+alpha*(y-hw)*hw*(1-hw)*x[a];
		}
	}
	@Override
	protected void trainingReport(List<Example> examples, int stepnum, int nsteps) {
		double accuracy=1-squaredErrorPerSample(examples);
		
		System.out.println(stepnum + "\t" + accuracy);
		plotter.addPoint((double)stepnum/nsteps, accuracy);
	}
	
	
	/**
	 * A LogisticClassifier uses a 0/1 sigmoid threshold at z=0.
	 */
	public double threshold(double z) {
		// This must be implemented by you
		
		return 1/(1+Math.exp(-z));
	}

}
