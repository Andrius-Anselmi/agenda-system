CREATE TABLE agenda (
    id serial PRIMARY KEY,
    descriacao VARCHAR(255),
    data_horario TIMESTAMP,
    data_criacao TIMESTAMP,
    paciente_id INTEGER,
    CONSTRAINT fk_agenda_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);