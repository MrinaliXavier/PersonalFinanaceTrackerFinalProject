package com.example.personalFinanceTracker.Repo;

import com.example.personalFinanceTracker.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepo extends JpaRepository<Dashboard, Long> {

}
