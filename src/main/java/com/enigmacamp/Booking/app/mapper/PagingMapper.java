package com.enigmacamp.Booking.app.mapper;

import com.enigmacamp.Booking.app.dto.request.PagingRequest;
import com.enigmacamp.Booking.app.dto.response.PagingResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PagingMapper {
    public PagingRequest mapPagingRequest(Integer page, Integer size) {
        return PagingRequest.builder()
                .page(page)
                .size(size)
                .build();
    }
    public PagingResponse mapPagingResponse(Page<?> pages, Integer page, Integer size) {
        return PagingResponse.builder()
                .content(pages.getContent())
                .totalData(pages.getTotalElements())
                .page(page)
                .size(size)
                .totalPages(pages.getTotalPages())
                .build();
    }
}
