package com.zz.base;

import com.mongodb.Block;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSUploadStream;
import com.mongodb.client.gridfs.model.GridFSDownloadOptions;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class TestGridFS {
	@Test
	public void uploadFile() {
		GridFSBucket gridFSBucket = MongoUtils2.getGridFSConn();
		
		try {
			GridFSUploadOptions options = new GridFSUploadOptions().chunkSizeBytes(358400);
			GridFSUploadStream uploadStream = gridFSBucket.openUploadStream("ts.txt", options);
			byte[] data = Files.readAllBytes(new File("D:\\temp\\gridfs\\ts.txt").toPath());
			
			uploadStream.write(data);
			uploadStream.close();
			System.out.println("文件 id 为：" + uploadStream.getObjectId().toHexString());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void downloadFile(){
		GridFSBucket gridFSBucket = MongoUtils2.getGridFSConn();
		try {
			FileOutputStream streamToDownloadTo = new FileOutputStream("D\\Mongo\\Data\\down_Redis.avi");
			GridFSDownloadOptions downloadOptions = new GridFSDownloadOptions().revision(0);
			gridFSBucket.downloadToStream("redis.avi",streamToDownloadTo, downloadOptions);
			gridFSBucket.downloadToStream(
					new ObjectId("5e74c48a9e825e638b2aeb5"),streamToDownloadTo);
					streamToDownloadTo.close();
		} catch (IOException e) {

        }
    }
	@Test
	public void renameFile(){
		GridFSBucket gridFSBucket=MongoUtils2.getGridFSConn();
		gridFSBucket.rename(
				new ObjectId("5e74c48a9e825e6386b2aeb5"),"Redis_new.avi");
	}
	@Test
	public void delFile(){
		GridFSBucket gridFSBucket=MongoUtils2.getGridFSConn();
		gridFSBucket.delete(new ObjectId(" "));
	}
	@Test
	public void getFiles(){
		GridFSBucket gridFSBucket = MongoUtils2.getGridFSConn();
		gridFSBucket.find().forEach(
				new Block<GridFSFile>(){
					public void apply(final GridFSFile gridFSFile) {
						System.out.println(
								"文件名:"+gridFSFile.getFilename()+" "
										+"文件大小:"+gridFSFile.getLength()+" "
										+"文件 id:"+gridFSFile.getId());
					}
				});
	}
}
