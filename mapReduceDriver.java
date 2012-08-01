package mapRedPackage;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class mapReduceDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		// Use programArgs array to retrieve program arguments.
		String[] programArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		
		if (programArgs.length<2) {
			System.out.println("Please check your inputs");
			System.exit(1);
		}
		
		Job job = new Job(conf,"Contoso");
		job.setJarByClass(mapReduceDriver.class);
		job.setMapperClass(mapperClass.class);
		job.setReducerClass(reduceClass.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setNumReduceTasks(5);

		FileInputFormat.addInputPath(job, new Path(programArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(programArgs[1]));
		long stime = System.currentTimeMillis();
		// Submit the job and wait for it to finish.
		job.waitForCompletion(true);
		long etime = System.currentTimeMillis();
		long ctime = etime - stime;
		System.out.println("Time taken by Job to complete : " +ctime);
		// Submit and return immediately: 
		// job.submit();
	}

}
