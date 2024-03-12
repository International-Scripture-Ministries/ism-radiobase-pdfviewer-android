export interface PDFViewPlugin {
  preview(url: { value: string }): Promise<{ value: string }>;
}
