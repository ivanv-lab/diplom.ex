package diplom.ex.dbcrud.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность обновления клиента")
public class ClientUpdateDto {
    @Schema(description = "ФИО")
    private String fio;
    @Schema(description = "E-mail")
    private String email;
    @Schema(description = "Номер телефона")
    private String phone;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
