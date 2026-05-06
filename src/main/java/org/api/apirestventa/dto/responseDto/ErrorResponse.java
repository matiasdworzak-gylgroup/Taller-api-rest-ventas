package org.api.apirestventa.dto.responseDto;

import java.time.LocalDateTime;

public record ErrorResponse(String mensaje,
                            int codigo,
                            LocalDateTime timestamp)
{
}
