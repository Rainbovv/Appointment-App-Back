package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.annotation.Loggable;
import com.stefanini.appointmentapp.entities.DailySchedule;
import com.stefanini.appointmentapp.service.DailyScheduleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/dailySchedules")
public class DailyScheduleController {

    DailyScheduleService dailyScheduleService;

    /**
     * Constructs and initiates DailyScheduleController object with instance of DailyScheduleService.
     * @param dailyScheduleService Instance of DailyScheduleService
     */
    public DailyScheduleController(DailyScheduleService dailyScheduleService) {
        this.dailyScheduleService = dailyScheduleService;
    }

    @Loggable
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    DailySchedule create(@RequestBody DailySchedule dailySchedule) {
        return dailyScheduleService.create(dailySchedule);
    }

    @Loggable
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    DailySchedule update(@RequestBody DailySchedule dailySchedule) {
        return dailyScheduleService.update(dailySchedule);
    }

    @Loggable
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody DailySchedule dailySchedule) {
        dailyScheduleService.delete(dailySchedule);
    }

    @Loggable
    @GetMapping("/{id}")
    DailySchedule findById(@PathVariable Long id) {
        return dailyScheduleService.findById(id);
    }

    @Loggable
    @GetMapping("")
    List<DailySchedule> findAll() {
        return dailyScheduleService.findAll();
    }
}
