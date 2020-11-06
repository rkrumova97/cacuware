package com.cacuware.file.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class File {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "counter")
	private Integer counter;

	@Column(name = "file_type")
	private String fileType;

	@Column(name = "file_businness_type")
	private Type fileBusinessType;

	@Column
	private byte[] file;

	public File(String fileName, String fileType, Type fileBusinessType, byte[] file, Integer number){
		this.file = file;
		this.fileBusinessType = fileBusinessType;
		this.fileName = fileName;
		this.fileType = fileType;
		this.counter = number;
	}

}
