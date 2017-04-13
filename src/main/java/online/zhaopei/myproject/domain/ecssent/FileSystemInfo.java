package online.zhaopei.myproject.domain.ecssent;

import java.io.Serializable;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;

public class FileSystemInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8070053231422774781L;

	public FileSystemInfo() {
	}
	
	public FileSystemInfo(FileSystem fileSystem, FileSystemUsage fileSystemUsage) {
		this.fileSystem = fileSystem;
		this.fileSystemUsage = fileSystemUsage;
	}
	
	private FileSystem fileSystem;
	
	private FileSystemUsage fileSystemUsage;

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}

	public FileSystemUsage getFileSystemUsage() {
		return fileSystemUsage;
	}

	public void setFileSystemUsage(FileSystemUsage fileSystemUsage) {
		this.fileSystemUsage = fileSystemUsage;
	}
}
