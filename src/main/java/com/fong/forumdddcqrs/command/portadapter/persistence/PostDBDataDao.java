package com.fong.forumdddcqrs.command.portadapter.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDBDataDao extends JpaRepository<PostDBData, String> {
}
