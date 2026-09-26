CREATE TABLE lines (
    line varchar NULL,
    inserted_at timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);