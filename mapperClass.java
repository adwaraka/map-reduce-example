package mapRedPackage;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.*;

public class mapperClass
		extends
		Mapper<LongWritable, Text, Text, IntWritable> {
		
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		Text product;
        String[] array = new String[10]; //temporary string
        int count = 0;
		String line = value.toString();
		final IntWritable one = new IntWritable(1);

        StringTokenizer lineTokens = new StringTokenizer(line, " ,=");
        while(lineTokens.hasMoreTokens()) {
            array[count] = lineTokens.nextToken();
            count++;
		}
        product = new Text(array[5]);
    	context.write(product, one);
	}	
}

