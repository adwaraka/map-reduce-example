package mapRedPackage;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class reduceClass
		extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	private IntWritable occurrencesOfProduct = new IntWritable();
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context) 
			throws IOException, InterruptedException {
		int sum = 0;
		for(IntWritable val : values) {
			sum +=val.get();
		}
		occurrencesOfProduct.set(sum);
		context.write(key, occurrencesOfProduct);
		//System.err.println(String.format("[reduce] Word: (%s), Count: (%d)", key, occurrencesOfProduct.get()));
	}

}
