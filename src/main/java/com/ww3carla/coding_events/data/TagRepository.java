package com.ww3carla.coding_events.data;

import com.ww3carla.coding_events.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
