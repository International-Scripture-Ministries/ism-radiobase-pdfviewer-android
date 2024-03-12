import { WebPlugin } from '@capacitor/core';

import type { PDFViewPlugin } from './definitions';

export class PDFViewWeb extends WebPlugin implements PDFViewPlugin {
  async preview(url: { value: string }): Promise<{ value: string }> {
    // console.log('ECHO', url);
    return url;
  }
}
