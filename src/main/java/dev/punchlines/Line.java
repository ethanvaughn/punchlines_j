package dev.punchlines;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "lines")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line")
    private String line;

    @Column(name = "inserted_at", nullable = false, updatable = false)
    private OffsetDateTime insertedAt;

    @Column(name = "modified_at", nullable = false)
    private OffsetDateTime modifiedAt;

    protected Line() {
    }

    public Line(String line) {
        this.line = line;
    }

    @PrePersist
    void onCreate() {
        OffsetDateTime now = OffsetDateTime.now();
        insertedAt = now;
        modifiedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        modifiedAt = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public OffsetDateTime getInsertedAt() {
        return insertedAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }
}
