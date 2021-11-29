package learn.lc.core;

import java.util.Arrays;

import learn.math.util.VectorOps;

public class PerceptronClassifier extends LinearClassifier {
	
	public PerceptronClassifier(double[] weights) {
		super(weights);
	}
	
	public PerceptronClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A PerceptronClassifier uses the perceptron learning rule
	 * (AIMA Eq. 18.7): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
		
		double hw=threshold(VectorOps.dot(this.weights, x));
		for(int a=0;a<this.weights.length;a++)
		{
			this.weights[a]=this.weights[a]+alpha*(y-hw)*x[a];
		}
		// This must be implemented by you
	}
	
	/**
	 * A PerceptronClassifier uses a hard 0/1 threshold.
	 */
	public double threshold(double z) {
		// This must be implemented by you
		
		
		if(z>=0)
		{
			return 1.0;
		}
		else
		{
			return 0;
		}
	}
	
}
