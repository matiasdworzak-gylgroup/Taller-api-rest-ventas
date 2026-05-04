package org.api.apirestventa.dto;

import java.time.LocalDateTime;

public record ErrorResponse(String mensaje,
                            int codigo,
                            LocalDateTime timestamp)
{
}
