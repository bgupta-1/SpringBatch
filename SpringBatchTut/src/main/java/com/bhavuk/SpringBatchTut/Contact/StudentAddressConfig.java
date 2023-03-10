//package com.bhavuk.SpringBatchTut.Contact;
//
//import javax.sql.DataSource;
//
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
//import org.springframework.batch.item.file.transform.Range;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.batch.item.validator.ValidatingItemProcessor;
//import org.springframework.batch.item.validator.ValidationException;
//import org.springframework.batch.item.validator.Validator;
//import com.bhavuk.SpringBatchTut.Address.Student;
//
//import lombok.AllArgsConstructor;
//
//@Configuration
//@AllArgsConstructor
//@EnableBatchProcessing
//public class StudentAddressConfig {
//	
//	
//	@Autowired
//	private DataSource datasource;
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//	@Bean
//	public StudentAddressProcessor processorAddress()
//	{
//		return new StudentAddressProcessor();
//	}
//	
//	
//	public FlatFileItemReader<StudentAddress> AddressReader()
//	{
//		FlatFileItemReader<StudentAddress> itemReader=new FlatFileItemReader<StudentAddress>();
//		itemReader.setResource(new FileSystemResource("src/main/resources/Addresses.dat"));
//		itemReader.setName("AddressMapper");
//		itemReader.setLineMapper(LineMapperAddress());
//		return itemReader;
//		
//	}
//
//
//	public LineMapper<StudentAddress> LineMapperAddress() {
//		// TODO Auto-generated method stub
//		DefaultLineMapper<StudentAddress> lineMapper=new DefaultLineMapper<>();
//		
//		FixedLengthTokenizer lineTokenizer=new FixedLengthTokenizer();
//		lineTokenizer.setStrict(false);
//		lineTokenizer.setNames("address_id","address_type","address_line1","address_line2","city","state_cd","zip_code","zip_plus_4");
//		lineTokenizer.setColumns(new Range[] {new Range(1,10), new Range(11,11) ,new Range(12,41), new Range(42,71), new Range(72,86), new Range(87,88), new Range(89,93), new Range(94,97)});
//	
//		BeanWrapperFieldSetMapper<StudentAddress> fieldMapper=new BeanWrapperFieldSetMapper<StudentAddress>();
//		fieldMapper.setTargetType(StudentAddress.class);
//		
//		
//		lineMapper.setFieldSetMapper(fieldMapper);
//		lineMapper.setLineTokenizer(lineTokenizer);
//		
//		return lineMapper;
//	}
//	@Bean
//	public JdbcBatchItemWriter<StudentAddress> writerAddress()
//	{
//		JdbcBatchItemWriter<StudentAddress> writer=new JdbcBatchItemWriter<StudentAddress>();
//		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<StudentAddress>());
//		writer.setDataSource(this.datasource);
//		writer.setSql("INSERT INTO address_bhavuk(address_id,address_line1,address_line2,address_type,city,state_cd,zip_code,zip_plus_4) VALUES(address_id,:address_line1,:address_line2,:address_type,:city,:state_cd,:zip_code,:zip_plus_4)");
//		return writer;
//		
//	}
//	@Bean
//	public Step step2()
//	{
//		return (Step) stepBuilderFactory.get("Uploading_StudentAddress")
//								 .<StudentAddress,StudentAddress>chunk(10)
//								 .reader(AddressReader())
//								 .processor(processorAddress())
//								 .writer(writerAddress())
//								 .build();
//		
//	}
//	@Bean
//	public Job executeJob()
//	{
//		return jobBuilderFactory.get("Executing_job2")
//				.incrementer(new RunIdIncrementer())
//				.flow(step2())
//				.end()
//				.build();
//		
//	}
//	
////	public Validator<StudentAddress> ValidatorProcessor()
////	{
////		Validator<StudentAddress> Processor=(Validator<StudentAddress>) new ValidatingItemProcessor<StudentAddress>();
////		Processor.setValidator();
////		return Processor;
////	}
//	
//	
//	
//	
//
//}
