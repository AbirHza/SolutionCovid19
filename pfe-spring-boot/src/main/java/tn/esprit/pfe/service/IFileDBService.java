package tn.esprit.pfe.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pfe.entities.FileDB;

public interface IFileDBService {

	public FileDB store(MultipartFile file) throws IOException;

	 public FileDB getFile(String id);
	 
	 public Stream<FileDB> getAllFiles();
}
