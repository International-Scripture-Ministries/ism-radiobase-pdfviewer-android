import { WebPlugin } from '@capacitor/core';
import type { PDFViewPlugin } from './definitions';
export declare class PDFViewWeb extends WebPlugin implements PDFViewPlugin {
    preview(url: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
