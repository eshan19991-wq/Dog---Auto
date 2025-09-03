
# Dog Auto (GitHub-ready)

This repository is prepared to build **Dog Auto** (phone + Android Auto car module) targeting **API 30**.
It includes a GitHub Actions workflow that will build both **debug** and **release** APKs.
The release APK will be signed with a test keystore generated inside the workflow (for development only).

## Quick steps after downloading this ZIP

1. Create a new GitHub repository (private or public).
2. Upload the contents of this folder (all files and folders) to the repo *root*.
3. Push to `main` (or upload via browser). The workflow will run automatically.
4. On GitHub: go to **Actions → Build DogAuto APK** → wait.
5. After success: download **Artifacts → DogAuto-APK** and extract APKs.

## Notes
- Test keystore alias: `dogauto` (storepass/keypass: `dogautopass`).
- This keystore is for development purposes only. Do not use it for Play Store publishing.
