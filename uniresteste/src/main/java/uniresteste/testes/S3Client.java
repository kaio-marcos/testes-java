package uniresteste.testes;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Client {
	private static String bucketName = "?";
	private static String bucketNameCarga = "?";
	
	private static String accessKey = "?";
	private static String secretKey = "?";
	
	public static void main(String[] args) {
		File file = new File("C:/Users/Kaio/Downloads/01- Regulamento Consultores Varejo_Desafio Relâmpago Novo Empresarial e Vida.PDF");
		String fileName = "missaoSeg/regulamento/desafio_relampago/consultores/_Regulamento Consultores Varejo_Desafio Relâmpago Novo Empresarial e Vida.PDF";
		
		//s3client().deleteObject(new DeleteObjectRequest(bucketName, fileName));
		
		s3client().putObject(new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
	}
	
	public static AmazonS3 s3client(){
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonS3Client.builder().withRegion("us-east-1").withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	}
	

}
