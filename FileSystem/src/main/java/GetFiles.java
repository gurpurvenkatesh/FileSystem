import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class GetFiles {

	public static void main(String[] args) throws IOException {
		
		String uri = args[0];
		
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get(URI.create(uri), conf); // Created the FileSytem object by creating URI of paths
		Path path = new Path(args[0]);
		
		FileStatus[] status = fs.listStatus(path); // Gets the array of FilStatus of paths
		Path[] paths = FileUtil.stat2Paths(status); // Generates the paths from the FileStatus object.
		
		for(Path p: paths){
			System.out.println(p.toString());	// Prints the paths present in directory
			
			Path path2 = new Path(p.toString() + "/*");
			FileStatus[] status2 = fs.globStatus(path2); // Gets the array of FilStatus of paths
			Path[] paths2 = FileUtil.stat2Paths(status2); // Generates the paths from the FileStatus object.
			
			for(Path p2: paths2){
				System.out.println(p2.toString());
			}
		}
		
		
	}

}
