package com.eprescription.eprescription.entity;
import com.eprescription.eprescription.entity.ItemType;
import com.eprescription.eprescription.entity.Instruction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "prescription_items")
public class PrescriptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many items belong to one prescription
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", nullable = false)
    @JsonIgnore
    private Prescription prescription;

    // TABLET / SYRUP / INJECTION
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType type;

    private String brand;
    private String medicineName;

    // Binary schedule (0/1 from frontend)
    private Boolean morning;
    private Boolean afternoon;
    private Boolean night;

    // Tablet specific
    private Boolean withWater;
    private Boolean chew;

    // Injection specific
    private Boolean daily;
    private Boolean alternateDay;
    private Boolean weeklyOnce;

    private Integer duration; // in days
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Instruction instruction; // BEFORE_FOOD / AFTER_FOOD / EMPTY_STOMACH

    // Constructors
    public PrescriptionItem() {}

    // Getters & Setters
    public Long getId() { return id; }

    public Prescription getPrescription() { return prescription; }
    public void setPrescription(Prescription prescription) { this.prescription = prescription; }

    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }

    public Boolean getMorning() { return morning; }
    public void setMorning(Boolean morning) { this.morning = morning; }

    public Boolean getAfternoon() { return afternoon; }
    public void setAfternoon(Boolean afternoon) { this.afternoon = afternoon; }

    public Boolean getNight() { return night; }
    public void setNight(Boolean night) { this.night = night; }

    public Boolean getWithWater() { return withWater; }
    public void setWithWater(Boolean withWater) { this.withWater = withWater; }

    public Boolean getChew() { return chew; }
    public void setChew(Boolean chew) { this.chew = chew; }

    public Boolean getDaily() { return daily; }
    public void setDaily(Boolean daily) { this.daily = daily; }

    public Boolean getAlternateDay() { return alternateDay; }
    public void setAlternateDay(Boolean alternateDay) { this.alternateDay = alternateDay; }

    public Boolean getWeeklyOnce() { return weeklyOnce; }
    public void setWeeklyOnce(Boolean weeklyOnce) { this.weeklyOnce = weeklyOnce; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Instruction getInstruction() { return instruction; }
    public void setInstruction(Instruction instruction) { this.instruction = instruction; }
}