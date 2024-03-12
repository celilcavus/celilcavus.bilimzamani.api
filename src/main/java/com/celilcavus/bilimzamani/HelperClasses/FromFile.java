package com.celilcavus.bilimzamani.HelperClasses;

import com.celilcavus.bilimzamani.Interfaces.IFromFile;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

import java.util.UUID;

@Repository
public class FromFile implements IFromFile {
    private final String PATH = "C:/Users/Celil/IdeaProjects/bilimzamani/src/main/java/com/celilcavus/bilimzamani/images/";

    @Override
    public String SaveImage(MultipartFile multipartFile) {
        try {
            String fileName = UUID.randomUUID() + multipartFile.getOriginalFilename();

            if (!multipartFile.isEmpty()) {
                FileOutputStream fos = new FileOutputStream(PATH.concat(fileName));

                fos.write(multipartFile.getBytes());
                fos.close();
                return fileName;
            } else
                return null;

        } catch (Exception ex) {
            System.out.println("exception ==== " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int DeleteImage(String imageName) {

      try{
          File file = new File(PATH.concat(imageName));
          if (file.exists()) {
              file.delete();
              return 1;
          }
          return 0;
      }catch (Exception ex)
      {
          System.out.println("DELETE EXCEPTION ==== " + ex.getMessage());
          return 0;
      }
    }
}
