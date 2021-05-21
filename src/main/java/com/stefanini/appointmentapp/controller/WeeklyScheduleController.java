package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.WeeklySchedule;
import com.stefanini.appointmentapp.service.WeeklyScheduleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @Loggable
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    WeeklySchedule create(@RequestBody WeeklySchedule weeklySchedule) {
        return weeklyScheduleService.create(weeklySchedule);
    }

    @Loggable
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    WeeklySchedule update(@RequestBody WeeklySchedule weeklySchedule) {
        return weeklyScheduleService.update(weeklySchedule);
    }

    @Loggable
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody WeeklySchedule weeklySchedule) {
        weeklyScheduleService.delete(weeklySchedule);
    }

    @Loggable
    @GetMapping("/{id}")
    WeeklySchedule findById(@PathVariable Long id) {
        return weeklyScheduleService.findById(id);
    }

    @Loggable
    @GetMapping("")
    List<WeeklySchedule> findAll() {
        return weeklyScheduleService.findAll();
    }
}
