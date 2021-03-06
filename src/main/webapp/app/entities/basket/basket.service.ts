import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { IBasket } from 'app/shared/model/basket.model';
import { createRequestOption } from '../../shared/util/request-util';

type EntityResponseType = HttpResponse<IBasket>;
type EntityArrayResponseType = HttpResponse<IBasket[]>;

@Injectable({ providedIn: 'root' })
export class BasketService {
    private resourceUrl = SERVER_API_URL + 'api/baskets';

    constructor(private http: HttpClient) {}

    create(basket: IBasket): Observable<EntityResponseType> {
        return this.http.post<IBasket>(this.resourceUrl, basket, { observe: 'response' });
    }

    update(basket: IBasket): Observable<EntityResponseType> {
        return this.http.put<IBasket>(this.resourceUrl, basket, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBasket>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBasket[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
