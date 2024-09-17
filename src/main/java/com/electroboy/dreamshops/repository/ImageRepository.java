package com.electroboy.dreamshops.repository;

import com.electroboy.dreamshops.model.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

  List<Image> findByProductId(Long id);
}