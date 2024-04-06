package com.bibliotheque.repository;


import com.bibliotheque.model.Download;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadRepository  extends JpaRepository<Download,Integer> {
}
