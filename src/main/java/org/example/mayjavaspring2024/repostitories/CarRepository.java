package org.example.mayjavaspring2024.repostitories;

import org.example.mayjavaspring2024.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByEnginePowerBetween(Long minEnginePower, Long maxEnginePower);

    List<Car> findByEnginePowerLessThan(Long maxEnginePower);

    List<Car> findByEnginePowerGreaterThan(Long maxEnginePower);
}
