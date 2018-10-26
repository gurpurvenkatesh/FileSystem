import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class copyMerge {

public static void main(String[] args) throws IOException {
		
		String uri = args[0];
		
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get(URI.create(uri), conf); // Created the FileSytem object by creating URI of paths
		Path srcPath = new Path(args[0]);
		Path trgtPath = new Path(args[1]);
		
		boolean copyMerge = FileUtil.copyMerge(fs, srcPath, fs, trgtPath, false, conf, null); 
		/* File System, source path for merging the files, fs, Target Path & File Name to store merged file,  
		true/path denotes if source files needed to be deleted after merge, configuration*/
		
		if(copyMerge)
			System.out.println("Merge Succesful");
	}
}
