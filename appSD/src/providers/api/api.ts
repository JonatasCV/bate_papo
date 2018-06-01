import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/do';

/**
 * Api is a generic REST Api handler. Set your API url first.
 */
@Injectable()
export class Api {
  url: string = 'https://example.com/api/v1';

  constructor(public http: HttpClient) {
  }
  getItems(endpoint: string, params?: any, reqOpts?: any) {
    if (!reqOpts) {
      reqOpts = {
        params: new HttpParams()
      };
    }

    // Support easy query params for GET requests
    if (params) {
      reqOpts.params = new HttpParams();
      for (let k in params) {
        reqOpts.params = reqOpts.params.set(k, params[k]);
      }
    }
    return this.http.get(this.url+endpoint, reqOpts).do(result => {return result});
  }


  get(endpoint: string, params?: any, reqOpts?: any) {
    if (!reqOpts) {
      reqOpts = {
        params: new HttpParams()
      };
    }

    // Support easy query params for GET requests
    if (params) {
      reqOpts.params = new HttpParams();
      for (let k in params) {
        reqOpts.params = reqOpts.params.set(k, params[k]);
      }
    }
    return this.http.get(endpoint, reqOpts).do(result => {return result});
  }

  post(endpoint: string, body: any, reqOpts?: any) {
    return this.http.post(endpoint, body, reqOpts).do(result => {return result});
  }

  put(endpoint: string, body: any, reqOpts?: any) {
    return this.http.put(endpoint, body, reqOpts).do(result => {return result});
  }

  delete(endpoint: string, reqOpts?: any) {
    return this.http.delete(endpoint, reqOpts).do(result => {return result});
  }

  patch(endpoint: string, body: any, reqOpts?: any) {
    return this.http.patch(endpoint, body, reqOpts).do(result => {return result});
  }
}
