package tn.esprit.pfe.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pfe.entities.FileDB;
import tn.esprit.pfe.repository.FileDBRepository;

@Service
public class FileDBServiceImpl implements IFileDBService {

	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private FileDBRepository fileDBRepository;
	@Override
	public FileDB store(MultipartFile file) throws IOException{
		// TODO Auto-generated method stub
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    return fileDBRepository.save(FileDB);
	}

	@Override
	public FileDB getFile(String id) {
		// TODO Auto-generated method stub
		return fileDBRepository.findById(id).get();
	}

	@Override
	public Stream<FileDB> getAllFiles() {
		// TODO Auto-generated method stub
		 return fileDBRepository.findAll().stream();
	}

}
