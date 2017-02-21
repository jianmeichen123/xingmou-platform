package ctdn.dao;


import ctdn.pojo.FilesInfo;
import ctdn.query.FilesQueryInfo;

import java.util.List;

public interface FilesDAO {
	
    Long update(FilesInfo files);


    List<FilesInfo> queryFiles(FilesQueryInfo filesQuery);
}