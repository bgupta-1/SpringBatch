package com.bhavuk.SpringBatchTut.Contact;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;

public class StudentAddressProcessor implements ItemProcessor<StudentAddress,StudentAddress> {

	@Override
	public StudentAddress process(StudentAddress item) throws Exception {
		// TODO Auto-generated method stub
//		Logger logger2 = (Logger) LoggerFactory.getLogger(LoggingController.class);
		
		
		//CompositeItemProcessor<I, O>
//		ClassifierCompositeItemProcessor<I, O> 
		
		
		return item;
	}

}
