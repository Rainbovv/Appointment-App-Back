package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.WeeklySchedule;
import com.stefanini.appointmentapp.service.WeeklyScheduleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/weeklySchedules")
public class WeeklyScheduleController {

    WeeklyScheduleService weeklyScheduleService;

    /**
     * Constructs and initiates WeeklyScheduleController object with instance of WeeklyScheduleService.
     * @param weeklyScheduleService Instance of WeeklyScheduleService
     */
    public WeeklyScheduleController(WeeklyScheduleService weeklyScheduleService) {
        this.weeklyScheduleService = weeklyScheduleService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    WeeklySchedule create(@RequestBody WeeklySchedule weeklySchedule) {
        return weeklyScheduleService.create(weeklySchedule);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    WeeklySchedule update(@RequestBody WeeklySchedule weeklySchedule) {
        return weeklyScheduleService.update(weeklySchedule);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody WeeklySchedule weeklySchedule) {
        weeklyScheduleService.delete(weeklySchedule);
    }

    @GetMapping("/{id}")
    WeeklySchedule findById(@PathVariable Long id) {
        return weeklyScheduleService.findById(id);
    }

    @GetMapping("")
    Set<WeeklySchedule> findAll() {
        return weeklyScheduleService.findAll();
    }
}
