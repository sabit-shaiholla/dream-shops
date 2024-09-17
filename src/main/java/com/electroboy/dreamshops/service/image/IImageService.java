package com.electroboy.dreamshops.service.image;

import com.electroboy.dreamshops.dto.ImageDto;
import com.electroboy.dreamshops.model.Image;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
  Image getImageById(Long id);
  void deleteImageById(Long id);
  List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
  void updateImage(MultipartFile file, Long imageId);
}
